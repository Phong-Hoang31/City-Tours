<template>
  <div>
    <h2>{{ landmark.landmarkName }}</h2>

      <v-carousel>
      <v-carousel-item
        v-for="(imageUrl,i) in landmark.imageUrlList"
        :key="i"
        :src="imageUrl"
        reverse-transition="fade-transition"
        transition="fade-transition"

      ></v-carousel-item>
    </v-carousel>

    <!-- <img :src="landmark.imageUrlList[0]" /> -->
    <h4>{{ landmark.description }}</h4>
    <h4>{{ landmark.category }}</h4>
    <h4>{{ landmark.upRatings }} thumbs up</h4>
    <h4>{{ landmark.downRatings }} thumbs down</h4>
  </div>
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
div {
  border: 2px solid black;
  text-align: center;
}

img {
  max-height: 300px;
}
</style>