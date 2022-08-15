<template>
  <div id="grid">
    <img id="logo" src="\assets\Cincinnati Local Look-1 (2).png" alt="Logo" />
    <div id="itineraryListContainer">
      <div v-for="itinerary of itineraries" :key="itinerary.id">
        <itinerary :itinerary="itinerary" />
      </div>
    </div>
        <create-itinerary id = "createItinerary"/>
  </div>
</template>

<script>
import itineraryServices from "../services/ItineraryServices";
import Itinerary from "./Itinerary.vue";
import CreateItinerary from "@/components/CreateItinerary.vue"

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
    CreateItinerary
  },
};
</script>

<style lang="scss" scoped>
#itineraryListContainer {
  grid-area: ga-itineraryList;
}

#logo {
  grid-area: ga-logo;
  max-block-size: 100px;
  border-radius: 50%;
  justify-self: center;
}

img {
  max-block-size: 100px;
  border-radius: 50%;
  justify-self: center;
}

#grid {
  display: grid;
  grid-template-columns: 1fr 3fr 1fr;
  grid-template-areas:
    "ga-logo . ."
    ". ga-itineraryList ga-createItinerary";
}

#createItinerary {
  grid-area: ga-createItinerary;
  justify-self: center;
}
</style>