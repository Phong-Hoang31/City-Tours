<template>
  <div class="container">
    <h2>{{ landmark.landmarkName }}</h2>
    <h4>{{ landmark.description }}</h4>
    <h4>{{ landmark.category }}</h4>
    <h4>{{ landmark.upRatings }} <i class="fa-regular fa-thumbs-up"></i></h4>
    <h4>
      {{ landmark.downRatings }} <i class="fa-regular fa-thumbs-down"></i>
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

<style lang="scss" scoped>
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
}
img {
  padding: 1rem;
  height: 250px;
}
</style>
