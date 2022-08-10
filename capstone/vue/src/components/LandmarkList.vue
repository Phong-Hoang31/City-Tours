<template>
  <div>
    <div>
      <input
        type="text"
        id="searchLandmark"
        placeholder="Search for landmarks..."
        v-model="filter.landmarkName"
      />
      <div style="background-color: pink; padding: 1rem;">
        <div id="categorySelector" v-for="category of landmarkCategories" v-bind:key="category.id"
> 

             <label for="category"> {{ category }}
       <input
       name="categoryChoice"
        type="radio"
        id="category"
         :value="category"
        v-model="filter.landmarkCategory"
      /></label>
        </div>
  
      </div>
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
         landmarkCategory: "",
      }
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
      for(let landmark of this.$store.state.landmarks) {
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
  },
};
</script>

<style scoped>
#searchLandmark {
  background-color: #faf0e6;
  padding: 1.5rem;
}

#categorySelector {
  padding-down: 1rem;
}

</style>