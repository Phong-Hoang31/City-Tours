<template>
  <div>
    <h2>{{ landmark.landmarkName }}</h2>
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
