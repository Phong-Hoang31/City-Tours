<template>
    <div>

    </div>
</template>

<script>
import itineraryServices from "../services/ItineraryServices";

    export default {
          name: "view-itinerary",

  created() {
    itineraryServices.getAllItineraries().then((response) => {
      this.$store.commit("POPULATE_ITINERARIES", response.data);
  })
  },
        
    }
</script>

<style lang="scss" scoped>

</style>