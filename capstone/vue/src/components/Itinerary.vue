<template>
  <div class="wrapper">
    <v-card class="mx-auto" width="400">
      <v-img
        class="white--text align-end"
        height="200px"
        src="https://best-itinerary.com/wp-content/uploads/2019/05/map-4x.png"
      >
      </v-img>

      <v-card-title>{{ itinerary.itineraryName }}</v-card-title>
      <v-card-subtitle class="pb-0"
        >{{ itinerary.itineraryDate }}
      </v-card-subtitle>
      <v-card-text
        v-if="grid - layout - toggler"
        id="card-text-grid"
        class="text--primary"
      >
        <div id="card-info">This is an itinerary</div>
        <add-landmark-to-itinerary
          id="add-landmark-button"
          :itinerary="itinerary"
        ></add-landmark-to-itinerary>
        <itinerary-details
          id="itinerary-details-button"
          :itinerary="itinerary"
        />
      </v-card-text>
      <v-card-text
        v-if="!grid - layout - toggler"
        id="card-text-grid-on-click"
        class="text--primary"
      >
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
import ItineraryDetails from "@/components/ItineraryDetails.vue";
import itineraryServices from "../services/ItineraryServices";
import AddLandmarkToItinerary from "@/components/AddLandmarkToItinerary.vue";

export default {
  data() {
    return {
      "grid-layout-toggler": true,
    };
  },
  components: { ItineraryDetails, AddLandmarkToItinerary },
  name: "Itinerary",
  props: {
    itinerary: Object,
  },
  methods: {
    addLandmarkToItinerary(itinerary, landmark) {
      itineraryServices
        .addLandmarkToItinerary(itinerary, landmark)
        .then((response) => {
          if (response.status === 201 || response.status === 200) {
            this.$router.go();
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style lang="scss" scoped>
.wrapper {
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-bottom: 20px;
}

#card-info {
  grid-area: ga-card-info;
}

#add-landmark-button {
  grid-area: ga-add-landmark-button;
}

#itinerary-details-button {
  grid-area: ga-itinerary-details-button;
}

#card-text-grid {
  display: grid;
  grid-template-columns: 2fr 2fr;
  grid-template-areas:
    "ga-card-info ga-card-info"
    "ga-add-landmark-button ga-itinerary-details-button";
}

#card-text-grid-on-click {
  display: grid;
  grid-template-columns:
    "ga-card-info ga-card-info"
    "ga-itinerary-details-button"
    "ga-add-landmark-button";
}

button {
  width: 30%;
  height: 40px;
  margin: 10px auto;
  justify-content: center;
  display: block;
  color: #fff;
  background: #573b8a;
  font-size: 1em;
  font-weight: bold;
  margin-top: 20px;
  outline: none;
  border: none;
  border-radius: 5px;
  transition: 0.2s ease-in;
  cursor: pointer;
}
</style>