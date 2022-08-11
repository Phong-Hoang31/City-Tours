<template>
  <div id="grid" class="hidden">
    <div id="searchBar">
      <v-col>
        <v-text-field
          v-model="filter.landmarkName"
          label="Enter search here..."
          filled
        ></v-text-field>
      </v-col>
    </div>
    <div id="radioSelector">
      <div
        id="categorySelector"
        v-for="category of landmarkCategories"
        v-bind:key="category.id"
      >
        <label for="category">
          {{ category }}
          <input
            name="categoryChoice"
            type="radio"
            id="category"
            :value="category"
            v-model="filter.landmarkCategory"
        /></label>
      </div>
    </div>
    <img id="logo" src="\assets\Cincinnati Local Look-1 (2).png" alt="Logo" />
    <create-itinerary id="createItinerary"></create-itinerary>
    <div id="landmarkListContainer">
      <div v-for="landmark in filteredList" v-bind:key="landmark.id">
        <landmark :landmark="landmark" />
      </div>
    </div>
  </div>
</template>

<script>
import Landmark from "./Landmark.vue";
import landmarkServices from "../services/LandmarkServices";
import CreateItinerary from "./CreateItinerary.vue";

export default {
  name: "landmark-list",
  data() {
    return {
      filter: {
        landmarkName: "",
        landmarkCategory: "",
      },
    };
  },
  created() {
    landmarkServices.getLandmarks().then((response) => {
      this.$store.commit("POPULATE_LANDMARKS", response.data);
    });
  },
  computed: {
    filteredList() {
      let filteredLandmarks = this.$store.state.landmarks;
      if (this.filter.landmarkName != "") {
        filteredLandmarks = this.$store.state.landmarks.filter((Landmark) =>
          Landmark.landmarkName
            .toLowerCase()
            .includes(this.filter.landmarkName.toLowerCase())
        );
      }
      //TODO: fix bug with using search and radio buttons for combined filtering
      if (this.filter.landmarkCategory != "") {
        filteredLandmarks = this.$store.state.landmarks.filter((Landmark) =>
          Landmark.category
            .toLowerCase()
            .includes(this.filter.landmarkCategory.toLowerCase())
        );
      }
      return filteredLandmarks;
    },
    landmarkCategories() {
      // TODO: remove duplicates
      let landmarkCategories = [];
      for (let landmark of this.$store.state.landmarks) {
        landmarkCategories.push(landmark.category);
      }
      return landmarkCategories;
    },
  },
  // methods: {
  //     landmarkCategories() {
  // // TODO: remove duplicates
  //       let landmarkCategories = [];
  //       for(let landmark of this.$store.state.landmarks) {
  //         landmarkCategories.push(landmark.category);
  //     }
  //     return landmarkCategories;
  //   },
  //   },
  components: {
    Landmark,
    CreateItinerary,
  },
};
</script>

<style scoped>
#searchBar {
  padding: 1rem;
  display: flex;
  justify-content: center;
  grid-area: ga-searchBar;
}

#landmarkListContainer {
  grid-area: ga-landmarkList;
}

#logo {
  grid-area: ga-logo;
}

img {
  max-block-size: 100px;
  border-radius: 50%;
  justify-self: center;
}

#grid {
  display: grid;
  grid-template-columns: 1fr 3fr 1fr;
  grid-template-areas:
    "ga-logo ga-searchBar ."
    "ga-radioSelector ga-landmarkList ga-createItinerary"
    ". ga-landmarkList .";
}

#categorySelector {
  padding-bottom: 1rem;
}

#radioSelector {
  grid-area: ga-radioSelector;
  justify-self: center;
  border: 1px solid black;
  padding: 2rem;
  text-transform: uppercase;
  font-size: 0.75rem;
  letter-spacing: 0.1rem;
}

#createItinerary {
  grid-area: ga-createItinerary;
}
</style>