<template>
  <div>
    <div>
      <input
        type="text"
        id="searchLandmark"
        placeholder="Search for landmarks..."
        v-model="filter.landmarkName"
      />
    </div>
    <div v-for="landmark in filteredList" v-bind:key="landmark.id">
      <landmark :landmark="landmark" />
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
  /*
  methods: {
  TODO: Make this method valid
  },
  getLandmark(landmarkId) {
  this.$router.push(`/landmarks/${landmarkId}`)
  },
  */

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
#searchLandmark {
  background-color: #faf0e6;
  padding: 1.5rem;
}
</style>