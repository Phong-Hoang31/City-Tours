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
      <div
        class="form-group"
        v-for="landmark in $store.state.landmarks"
        :key="landmark.id"
      >
        <!-- Pull in list of landmarks from the store, then iterate through in select 
element. Each option (v-for on the option) will be a landmark. -->
        <h6 @click="addLandmarkToItinerary(itinerary.itineraryId, landmark.landmarkID)">
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
  background: yellow;
  display: inline-block;
}

#addLandmarkForm {
  margin-top: 1rem;
}
</style>