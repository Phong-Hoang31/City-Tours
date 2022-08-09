<template>
  <div>
    <h2>{{ landmark.landmarkName }}</h2>
    <h2>{{ landmark.landmarkName }}</h2>
    <img :src="landmark.imageUrlList[0]" />
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
