<template>
  <div class="home">
    <h1>Cininatti Local Looks</h1>
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
