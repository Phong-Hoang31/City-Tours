<template>
  <div class="body">
    <v-expansion-panels focusable>
      <v-expansion-panel>
        <v-expansion-panel-header>CREATE ITINERARY</v-expansion-panel-header>
        <v-expansion-panel-content>
          <form
            id="addItineraryForm"
            class="form"
            v-on:submit.prevent="submitForm"
          >
            <div class="form-group">
              <label for="itineraryName">Itinerary Name: </label>
              <input
                required
                id="itineraryId"
                type="text"
                class="form-control"
                v-model="itinerary.itineraryName"
              />
            </div>

            <div class="form-group">
              <label for="startingPoint">Starting Point: </label>
              <input
                required
                id="startPoint"
                type="text"
                class="form-control"
                v-model="itinerary.startingPoint"
              />
            </div>
            <div class="form-group">
              <label for="itineraryDate">Date of Itinerary: </label>
              <input
                required
                id="itineraryDate"
                type="date"
                class="form-control"
                v-model="itinerary.itineraryDate"
              />
            </div>
            <div id="submitClearButtons">
              <button class="btn btn-submit btn-info" type="submit">
                Submit
              </button>
              <button
                class="btn btn-cancel btn-secondary"
                type="button"
                value="cancel"
                v-on:click="clearForm"
              >
                Clear
              </button>
            </div>
          </form>
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-expansion-panels>
  </div>
</template>

<script>
import itineraryServices from "../services/ItineraryServices";

export default {
  name: "create-itinerary",
  data() {
    return {
      showForm: false,
      userId: null,
      itinerary: {
        name: "",
        startingPoint: "",
        date: "",
      },
    };
  },
  created() {},

  methods: {
    submitForm() {
      itineraryServices
        .createItinerary(this.itinerary)
        .then((response) => {
          if (response.status === 201 || response.status === 200) {
            itineraryServices.getAllItineraries().then((response) => {
              this.$store.commit("POPULATE_ITINERARIES", response.data);
              this.itinerary = {};
            });
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    clearForm() {
      this.itinerary = {};
      /**
       * I commented this out because it caused the page to reload,
       * and I don't think we want that.
       * this.$router.go();
       */
    },
  },
};
</script>

<style lang="scss" scoped>
#addItineraryForm {
  margin-top: 1rem;
}

#submitClearButtons {
  display: flex;
  justify-content: space-between;
}
</style>