<template>
  <div class="itineraries">
    <h3>MY ITINERARIES</h3>
    <itinerary-list />
  </div>
</template>

<script>
import ItineraryList from "@/components/ItineraryList.vue";

export default {
  name: "Itineraries",
  components: {
    ItineraryList,
  },
};
</script>

<style lang="scss" scoped>
h3 {
  text-align: center;
  letter-spacing: 0.75rem;
  font-size: 1rem;
  width: 95%;
}
</style>