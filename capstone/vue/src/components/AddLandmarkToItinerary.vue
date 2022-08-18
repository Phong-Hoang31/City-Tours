<template>
  <div>
    <button
      id="add-landmark-button"
      type="button"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >
      Add Landmark
    </button>
    <form
      id="addLandmarkForm"
      v-on:submit.prevent="submitForm"
      v-if="showForm === true"
    >
      <h5 id="addLandmarksTitle">LANDMARKS TO ADD</h5>
      <div
        class="form-group"
        v-for="landmark in unselectedLandmarks"
        :key="landmark.id"
      >
        <!-- Pull in list of landmarks from the store, then iterate through in select 
element. Each option (v-for on the option) will be a landmark. -->
        <h6
          @click="
            addLandmarkToItinerary(itinerary.itineraryId, landmark.landmarkID)
          "
        >
          {{ landmark.landmarkName }}
        </h6>
      </div>

      <button
        class="btn btn-cancel btn-secondary"
        type="button"
        value="cancel"
        v-on:click="cancelForm"
      >
        Cancel
      </button>
    </form>
  </div>
</template>

<script>
import landmarkServices from "../services/LandmarkServices";
import ItineraryServices from "@/services/ItineraryServices";

export default {
  name: "addLandmarkToItinerary",
  props: ["itinerary"],
  data() {
    return {
      showForm: false,
      userId: null,
    };
  },
  /**
   * Not sure if in production it makes sense to use created
   * lifecycle hook in each component it is used individually.
   */
  created() {
    landmarkServices.getLandmarks().then((response) => {
      this.$store.commit("POPULATE_LANDMARKS", response.data);
    });
  },
  computed: {
    /**
     * unselectedLandmarks() first checks for the filter by category, if it is used
     * then we enter a nested conditional to account for the value bound to
     * the searchbar (landmarkName). If we don't use the filter by category
     * and only use the searchbar, then we bounce to the second check i.e.
     * the 'else if' statement.
     */
    unselectedLandmarks() {
      let unselectedLandmarks = this.$store.state.landmarks.filter(
        (Landmark) =>
          !this.itinerary.landmarkList.find(
            (lm) => Landmark.landmarkID === lm.landmarkID
          )
      );

      return unselectedLandmarks;
    },
  },
  methods: {
    cancelForm() {
      this.showForm = false;
    },
    /**
     * Might not need this if calling method directly from service in HTML
     */
    addLandmarkToItinerary(itinerary, landmark) {
      ItineraryServices.addLandmarkToItinerary(itinerary, landmark)
        .then((response) => {
          if (response.status === 201 || response.status === 200) {
            ItineraryServices.getAllItineraries().then((response) => {
              this.$store.commit("POPULATE_ITINERARIES", response.data);
            });
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style lang="scss" scoped>
button {
  width: 80%;
  height: 40px;
  margin: 10px auto;
  justify-content: center;
  display: block;
  color: #fff;
  background: #573b8a;
  font-size: 1em;
  font-weight: bold;
  margin-top: 20px;
  outline: none;
  border: none;
  border-radius: 5px;
  transition: 0.2s ease-in;
  cursor: pointer;
}

h6:hover {
  cursor: pointer;
  border-left: 1px black solid;
  padding-left: 1rem;
}

#addLandmarksTitle {
  padding: 1rem;
  text-align: center;
  border-top: 1px black solid;
  letter-spacing: 0.25rem;
}

#addLandmarkForm {
  margin-top: 1rem;
  padding: 1rem;
}
</style>