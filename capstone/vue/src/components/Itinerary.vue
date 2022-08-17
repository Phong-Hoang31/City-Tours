<template>
  <div class="wrapper">
    <v-card class="mx-auto" width="400">
      <!-- <v-img
        class="white--text align-end"
        height="200px"
        src="https://best-itinerary.com/wp-content/uploads/2019/05/map-4x.png"
      >
      </v-img> -->
      <v-carousel
        hide-delimiters
        :show-arrows="false"
        cycle
        height="250px"
        continuous
        interval="4000"
      >
        <v-carousel-item
          v-for="imageUrl in itineraryImages"
          :key="imageUrl"
          :src="imageUrl"
        ></v-carousel-item>
      </v-carousel>

      <v-card-title>{{ itinerary.itineraryName }}</v-card-title>
      <v-card-subtitle class="pb-0"
        >{{ itinerary.itineraryDate }}
      </v-card-subtitle>
      <v-card-text id="card-text-grid" class="text--primary">
        <div id="card-info">This is an itinerary</div>
        <add-landmark-to-itinerary
          id="add-landmark-button"
          :itinerary="itinerary"
        ></add-landmark-to-itinerary>
        <itinerary-details id="itinerary-details" :itinerary="itinerary" />
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
      images: [],
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
  computed: {
    itineraryImages() {
      let images = [];
      for (let i = 0; i < this.itinerary.landmarkList[0]; i++) {
        // for (
        //   let nested_i = 0;
        //   nested_i < this.itinerary.landmarkList[i].imageUrlList;
        //   i++
        // )
        // {
        //   images.push(this.itinerary.landmarkList[i].imageUrlList[nested_i]);
        // }

        images.push(this.itinerary.landmarkList[0].imageUrlList[i]);
      }
      if (images > 0) {
        return images;
      } else {
        return [
          "https://hips.hearstapps.com/hmg-prod/images/tc-wtg-2019-index-1543252150.jpg",
        ];
      }
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

#itinerary-details {
  grid-area: ga-itinerary-details;
}

#card-text-grid {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "ga-card-info ga-card-info ga-card-info"
    "ga-itinerary-details ga-itinerary-details ga-itinerary-details"
    "ga-add-landmark-button ga-add-landmark-button ga-add-landmark-button";
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