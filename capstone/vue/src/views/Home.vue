<template>
  <div class="home">
    <h1>Cincinnati Local Looks</h1>
    <landmark-list />
    <sidebar-display></sidebar-display>
  </div>
</template>

<script>
import LandmarkList from "@/components/LandmarkList.vue";
import SidebarDisplay from "@/components/Sidebar.vue"

export default {
  name: "Home",
  components: {
    LandmarkList,
    SidebarDisplay
  },
};
</script>
<style scoped>

</style>
