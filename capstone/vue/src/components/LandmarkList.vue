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

<style>
div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review.favorited {
  background-color: lightyellow;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}
</style>