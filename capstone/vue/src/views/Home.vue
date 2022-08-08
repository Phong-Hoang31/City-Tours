<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
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
