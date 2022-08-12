<template>
  <div>
    <div v-for="itinerary of itineraries" :key="itinerary.id">
      <itinerary :itinerary="itinerary" />
    </div>
  </div>
</template>

<script>
import itineraryServices from "../services/ItineraryServices";
import Itinerary from "./Itinerary.vue";

export default {
  name: "itinerary-list",
  data() {
    return {
      itineraries: this.$store.state.itineraries,
    };
  },
  created() {
    itineraryServices.getAllItineraries().then((response) => {
      this.$store.commit("POPULATE_ITINERARIES", response.data);
    });
  },
  components: {
    Itinerary,
  },
};
</script>

<style lang="scss" scoped>
</style>