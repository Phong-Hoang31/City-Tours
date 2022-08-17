<template>
  <div class="home">
    <h3>CINCINNATI LOCAL LOOKS</h3>
    <landmark-list class="list" />
    <sidebar-display class="display"></sidebar-display>
  </div>
</template>

<script>
import LandmarkList from "@/components/LandmarkList.vue";
import SidebarDisplay from "@/components/Sidebar.vue";

export default {
  name: "Home",
  components: {
    LandmarkList,
    SidebarDisplay,
  },
};
</script>

<style scoped>
h3 {
  text-align: center;
  letter-spacing: 0.75rem;
}
</style>
