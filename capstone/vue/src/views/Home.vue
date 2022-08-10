<template>
  <div class="home">
    <h3>CINCINNATI LOCAL LOOKS</h3>
    <landmark-list />
  </div>
</template>

<script>
import LandmarkList from "@/components/LandmarkList.vue";

export default {
  name: "Home",
  components: {
    LandmarkList,
  },
};
</script>

<style scoped>
h3 {
  text-align: center;
  letter-spacing: 0.75rem;
}
</style>