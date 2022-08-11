<template>
  <div class="home">
    <h3>CINCINNATI LOCAL LOOKS</h3>
    <landmark-list />
    <sidebar-display></sidebar-display>
    <itinerary-view></itinerary-view>
  </div>
</template>

<script>
import LandmarkList from "@/components/LandmarkList.vue";
import SidebarDisplay from "@/components/Sidebar.vue";
import ItineraryView from "@/components/ItineraryView.vue"

export default {
  name: "Home",
  components: {
    LandmarkList,
    SidebarDisplay,
    ItineraryView
  },
};
</script>

<style scoped>
h3 {
  text-align: center;
  letter-spacing: 0.75rem;
}
</style>
