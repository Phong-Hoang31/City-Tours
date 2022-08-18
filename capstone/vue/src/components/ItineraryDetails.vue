<template>
  <div class="body">
    <form id="detailsForm" v-on:submit.prevent="submitForm">
      <ol>
        <div v-for="landmark in itinerary.landmarkList" :key="landmark.id">
          <li class="form-group">
            <h6>
              {{ landmark.landmarkName }}
            </h6>
            <div id="icons">
              <i
                id="caret-up"
                @click="decrementLandmarkOrder(itinerary, landmark)"
                class="fa-solid fa-caret-up"
              ></i>
              <i
                id="caret-down"
                @click="incrementLandmarkOrder(itinerary, landmark)"
                class="fa-solid fa-caret-down"
              ></i>
              <i
                id="trashcan"
                @click="deleteLandmarkFromItinerary(itinerary, landmark)"
                class="fa-solid fa-trash-can"
              ></i>
            </div>
          </li>
          <p>{{ landmark.description }}</p>
        </div>
      </ol>
    </form>
  </div>
</template>

<script>
import itineraryServices from "../services/ItineraryServices";

export default {
  name: "itinerary-details",
  props: ["itinerary"],
  methods: {
    deleteLandmarkFromItinerary(itinerary, landmark) {
      itineraryServices
        .deleteLandmarkFromItinerary(itinerary.itineraryId, landmark.landmarkID)
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
    incrementLandmarkOrder(itinerary, landmark) {
      itineraryServices
        .incrementLandmarkOrder(itinerary.itineraryId, landmark.landmarkOrder)
        .then((response) => {
          if (response.status === 201 || response.status === 200) {
            this.$store.commit("INCREMENT_LANDMARK_ORDER", {
              itineraryId: itinerary.itineraryId,
              landmarkId: landmark.landmarkID,
            });
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    decrementLandmarkOrder(itinerary, landmark) {
      itineraryServices
        .decrementLandmarkOrder(itinerary.itineraryId, landmark.landmarkOrder)
        .then((response) => {
          if (response.status === 201 || response.status === 200) {
            this.$store.commit("DECREMENT_LANDMARK_ORDER", {
              itineraryId: itinerary.itineraryId,
              landmarkId: landmark.landmarkID,
            });
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
button {
  width: 80%;
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

#detailsForm {
  margin-top: 1rem;
  max-height: 350px;
  overflow: auto;
}

.form-group {
  padding-top: 0.2rem;
  display: flex;
  justify-content: space-between;
  align-content: center;
}

#caret-up {
  font-size: 1.25rem;
}

#caret-up:hover {
  cursor: pointer;
}

#caret-down {
  font-size: 1.25rem;
}

#caret-down:hover {
  cursor: pointer;
}

#trashcan:hover {
  cursor: pointer;
  color: red;
}

#icons {
  width: 100px;
  display: flex;
  justify-content: space-evenly;
  visibility: hidden;
}

.form-group:hover {
  border-bottom: 1px dotted black;
}

.form-group:hover #icons {
  visibility: visible;
}
</style>