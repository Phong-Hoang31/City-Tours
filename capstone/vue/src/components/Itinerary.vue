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
      <v-card-text class="text--primary">
        <div>This is an itinerary</div>

         <button
      id="add-landmark-button"
      type="button"
      v-on:click.prevent="showForm = true" 
    >
      Add Landmark
    </button>

         <itinerary-details :itinerary="itinerary" />
      </v-card-text>

      <!-- <v-card-actions>
        <v-btn color="blue">
          Button 1
          <i class="fa-regular fa-thumbs-up"></i>
        </v-btn>

        <v-btn color="red">
          Button 2
          <i class="fa-regular fa-thumbs-down"></i>
        </v-btn>
      </v-card-actions> -->
    </v-card>   
  </div>
</template>

<script>
import ItineraryDetails from "@/components/ItineraryDetails.vue";
import itineraryServices from "../services/ItineraryServices";

export default {
    components: { ItineraryDetails },
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
    }
  }
};
</script>

<style lang="scss" scoped>

.wrapper {
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-bottom: 20px;
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