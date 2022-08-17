<template>
  <div class="body">
    <button
      id="show-form-button"
      type="button"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >
      Show Details
    </button>
    <form
      id="detailsForm"
      v-on:submit.prevent="submitForm"
      v-if="showForm === true"
    >
      <div class="form-group">
        <h6 for="landmarkAddress">Address:</h6>
        <p>{{ landmark.address }}</p>
      </div>

      <div class="form-group">
        <ul for="Schedule">
          <h6>Open Hours:</h6>
          <li v-for="time in landmark.scheduleList" :key="time.id">
            <span>{{ time.dayName }}:</span>
            {{ time.openTime }} - {{ time.closeTime }}
          </li>
        </ul>
      </div>
      <div class="form-group">
        <h6 for="landmarkPrice">Price:</h6>
        {{ landmark.price }}
      </div>
      <v-card-actions>
        <v-btn
          @click="
            toggleButton();
            upVote();
          "
          :disabled="isDisabled ? true : false"
        >
          <i class="fa-regular fa-thumbs-up"></i>
          {{ landmark.upRatings }}
        </v-btn>

        <v-btn
          @click="
            toggleButton();
            downVote();
          "
          :disabled="isDisabled ? true : false"
        >
          <i class="fa-regular fa-thumbs-down"></i>
          {{ landmark.downRatings }}
        </v-btn>
      </v-card-actions>
      <button
        class="btn btn-cancel btn-secondary"
        type="button"
        value="cancel"
        v-on:click="cancelForm"
      >
        Hide
      </button>
    </form>
  </div>
</template>

<script>
import LandmarkServices from "@/services/LandmarkServices";

export default {
  name: "landmark_details",
  props: ["landmark"],
  data() {
    return {
      showForm: false,
      isDisabled: false,
      userId: null,
    };
  },
  created() {
    // this.userId = this.$store.state.user.id;
    // this.itinerary.userId = this.userId;
  },

  methods: {
    cancelForm() {
      this.showForm = false;
    },
    /**
     * Stops the same user from being able to vote multiple times on a landmark
     * but only for this session. If they reload or log back in they can vote again.
     */
    toggleButton() {
      this.isDisabled = !this.isDisabled;
    },
    upVote() {
      LandmarkServices.updateUpRatingsForLandmark(this.landmark.landmarkID);
    },
    downVote() {
      LandmarkServices.updateDownRatingsForLandmark(this.landmark.landmarkID);
    },
  },
};
</script>


<style scoped>
button {
  width: 30%;
  height: 40px;
  margin: 10px auto;
  justify-content: center;
  display: block;
  color: #fff;
  background: #573b8a;
  font-size: 1rem;
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
}

ul {
  list-style: none;
}
h6 {
  font-size: 1.3em;
  font-weight: 800;
  margin-top: 1rem;
  color: #573b8a;
}
ul {
  list-style: none;
}
span {
  font-weight: 600;
}
</style>
