<template>
  <div id="grid">
    <div id="searchBar">
      <v-col>
        <v-text-field
          v-model="filter.landmarkName"
          label="Enter search here..."
          filled
        ></v-text-field>
      </v-col>
    </div>
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

export default {
  name: "landmark-list",
  data() {
    return {
      filter: {
        landmarkName: "",
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
      return filteredLandmarks;
    },
  },
  components: {
    Landmark,
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

#grid {
  display: grid;
  grid-template-columns: 1fr 3fr 1fr;
  grid-template-areas:
    ". ga-searchBar ."
    ". ga-landmarkList ."
    ". ga-landmarkList .";
}
</style>