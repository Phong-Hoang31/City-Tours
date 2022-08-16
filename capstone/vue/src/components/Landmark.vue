<template>
  <div class="wrapper">
    <v-card class="mx-auto" width="400">
      <v-carousel
        hide-delimiters
        :show-arrows="false"
        cycle
        height="250px"
        continuous
        interval="4000"
      >
        <v-carousel-item
          v-for="imageUrl in landmark.imageUrlList"
          :key="imageUrl"
          :src="imageUrl"
        ></v-carousel-item>
      </v-carousel>
      <!-- <v-img
        class="white--text align-end"
        height="200px"
        :src="landmark.imageUrlList[0]"
      >
      </v-img> -->

      <v-card-title class="title">{{ landmark.landmarkName }}</v-card-title>
      <v-card-subtitle class="pb-0">{{ landmark.category }} </v-card-subtitle>
      <v-card-text class="text--primary">
        <div>{{ landmark.description }}</div>
        <landmark-details :landmark="landmark" />
      </v-card-text>
      <!--       
  Taking the up and down vote button functionality out of thumbnail card.
  This will be implemented in detail view.

      <v-card-actions>
        <v-btn color="blue">
          {{ landmark.upRatings }}
          <i class="fa-regular fa-thumbs-up"></i>
        </v-btn>

        <v-btn color="red">
          {{ landmark.downRatings }}
          <i class="fa-regular fa-thumbs-down"></i>
        </v-btn>
      </v-card-actions> -->
    </v-card>
  </div>
</template>

<script>
import LandmarkDetails from "./LandmarkDetails.vue";
export default {
  components: { LandmarkDetails },
  name: "Landmark",
  props: {
    landmark: Object,
  },
};
</script>

<style scoped>
.wrapper {
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-bottom: 20px;
}
button {
  width: 30%;
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
.title {
  font-size: 1.4em;
  font-weight: 800;
  margin-top: 1rem;
  color: #573b8a;
}
/* 
.container {
  padding: 1rem;
  margin: 25px auto 25px auto;
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 2px solid black;
  justify-content: center;
  flex-wrap: wrap;
  max-width: 500px;
} */
</style>
