<template>
  <div class="itineraries">
    <h3>MY ITINERARIES</h3>
    <ItineraryList />
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
  margin-bottom: 20px;
}
</style>