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
        id="carousel"
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

      <v-card-title>
        <input
          v-model="itineraryName"
          @keydown.enter="updateItineraryName(itinerary)"
          :placeholder="itinerary.itineraryName"
        />
      </v-card-title>

      <v-card-subtitle class="pb-0">
        <i
          id="deleteItineraryTrashcan"
          @click="deleteItinerary(itinerary)"
          class="fa-solid fa-trash-can"
        ></i>
        <div id="card-info">Starting Point: {{ itinerary.startingPoint }}</div>
        {{ itinerary.itineraryDate }}
      </v-card-subtitle>
      <v-card-text id="card-text-grid" class="text--primary">
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
      itineraryName: "",
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
        .addLandmarkToItinerary(itinerary.itineraryId, landmark.landmarkID)
        .then((response) => {
          if (response.status === 201 || response.status === 200) {
            this.$router.go();
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    updateItineraryName(itinerary) {
      let itineraryId = itinerary.itineraryId;
      let itineraryName = this.itineraryName;
      itineraryServices.updateItineraryName(itinerary.itineraryId, itinerary);
      this.$store.commit("UPDATE_ITINERARY_NAME", {
        itineraryId: itineraryId,
        itineraryName: itineraryName,
      });
    },
    deleteItinerary(itinerary) {
      itineraryServices
        .deleteItinerary(itinerary.itineraryId)
        .then((response) => {
          if (response.status === 201 || response.status === 200) {
            itineraryServices.getAllItineraries().then((response) => {
              this.$store.commit("POPULATE_ITINERARIES", response.data);
            });
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
      for (let i = 0; i < this.itinerary.landmarkList.length; i++) {
        for (
          let nested_i = 0;
          nested_i < this.itinerary.landmarkList[i].imageUrlList.length;
          nested_i++
        ) {
          images.push(this.itinerary.landmarkList[i].imageUrlList[nested_i]);
        }
      }
      if (images.length > 0) {
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

input {
  width: 100%;
  height: 2rem;
  margin-bottom: 1rem;
  resize: none;
}

input:hover {
  border-bottom: 1px dotted black;
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
#trashcan {
  display: flexbox;
  margin: 0px 16px 0px;
}

#deleteItineraryTrashcan {
  display: block;
  position: absolute;
  right: 20px;
}

#deleteItineraryTrashcan:hover {
  color: red;
  cursor: pointer;
}
</style>