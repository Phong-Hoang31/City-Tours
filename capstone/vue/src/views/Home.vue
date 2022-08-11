<template>
  <div class="home">
    <h3>CINCINNATI LOCAL LOOKS</h3>
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
<<<<<<< HEAD
<style scoped>

</style>
=======

<style scoped>
h3 {
  text-align: center;
  letter-spacing: 0.75rem;
}
</style>
>>>>>>> d891ccb08ba5636e6f332dddfe6f2e3986a224fc
