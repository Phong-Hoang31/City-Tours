<template>
  <div class="wrapper">
    <v-card class="mx-auto" width="400">
      <v-img
        class="white--text align-end"
        height="200px"
        :src="landmark.imageUrlList[0]"
      >
      </v-img>

      <v-card-title>{{ landmark.landmarkName }}</v-card-title>
      <v-card-subtitle class="pb-0">{{ landmark.category }} </v-card-subtitle>
      <v-card-text class="text--primary">
        <div>{{ landmark.description }}</div>
      </v-card-text>

      <v-card-actions>
        <v-btn color="blue">
          {{ landmark.upRatings }} <i class="fa-regular fa-thumbs-up"></i>
        </v-btn>

        <v-btn color="red">
          {{ landmark.downRatings }} <i class="fa-regular fa-thumbs-down"></i>
        </v-btn>
      </v-card-actions>
    </v-card>
  </div>

  <!-- <div class="container">
    <h2>{{ landmark.landmarkName }}</h2>
    <h4>{{ landmark.description }}</h4>
    <h4>{{ landmark.category }}</h4>
    <h4>
      <span style="color: blue"
        >{{ landmark.upRatings }} <i class="fa-regular fa-thumbs-up"></i
      ></span>
    </h4>
    <h4>
      <span style="color: red">
        {{ landmark.downRatings }} <i class="fa-regular fa-thumbs-down"></i
      ></span>
    </h4>
    <v-carousel>
      <v-carousel-item
        v-for="(imageUrl, i) in landmark.imageUrlList"
        :key="i"
        :src="imageUrl"
        reverse-transition="fade-transition"
        transition="fade-transition"
      ></v-carousel-item>
    </v-carousel>
  </div> -->
</template>

<script>
export default {
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
