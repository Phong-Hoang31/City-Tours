<template>
  <div class="body">
    <v-expansion-panels focusable>
      <v-expansion-panel>
        <v-expansion-panel-header>CREATE ITINERARY</v-expansion-panel-header>
        <v-expansion-panel-content>
          <form class="form" v-on:submit.prevent="submitForm">
            <div class="form-group">
              <label for="itineraryName">Itinerary Name: </label>
              <input
                id="itineraryId"
                type="text"
                class="form-control"
                v-model="itinerary.itineraryName"
              />
            </div>

            <div class="form-group">
              <label for="startingPoint">Starting Point: </label>
              <input
                id="startPoint"
                type="text"
                class="form-control"
                v-model="itinerary.startingPoint"
              />
            </div>
            <div class="form-group">
              <label for="itineraryDate">Date of Itinerary: </label>
              <input
                id="itineraryDate"
                type="date"
                class="form-control"
                v-model="itinerary.itineraryDate"
              />
            </div>
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
          </form>
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-expansion-panels>
    <!-- <button
      id="show-form-button"
      href="#"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >
      CREATE ITINERARY
    </button> -->
    <!-- <form
      class="form"
      v-on:submit.prevent="submitForm"
      v-if="showForm === true"
    > -->
    <!-- <div class="form-group">
        <label for="itineraryName">Itinerary Name: </label>
        <input
          id="itineraryId"
          type="text"
          class="form-control"
          v-model="itinerary.itineraryName"
        />
      </div>

      <div class="form-group">
        <label for="startingPoint">Starting Point: </label>
        <input
          id="startPoint"
          type="text"
          class="form-control"
          v-model="itinerary.startingPoint"
        />
      </div>
      <div class="form-group">
        <label for="itineraryDate">Date of Itinerary: </label>
        <input
          id="itineraryDate"
          type="date"
          class="form-control"
          v-model="itinerary.itineraryDate"
        />
      </div>
      <button class="btn btn-submit btn-info" type="submit">Submit</button>
      <button
        class="btn btn-cancel btn-secondary"
        type="button"
        value="cancel"
        v-on:click="cancelForm"
      >
        Cancel
      </button>
    </form> -->
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
            this.$router.go();
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
    addLandmarkToItinerary(itinerary, landmark) {
      itineraryServices
        .addLandmarkToItinerary(itinerary, landmark)
        .then((response) => {
          if (response.status === 201 || response.status === 200) {
            this.$router.go();
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
</style>