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
      class="form"
      v-on:submit.prevent="submitForm"
      v-if="showForm === true"
    >
      <div class="form-group">
        <label for="landmarkAddress">Address: </label>
        <p>Needs to wire address in here</p>
      </div>

      <div class="form-group">
        <ul style="list-style: none" for="Schedule">
          <div class="schedule-info">Open Hours:</div>
          <li v-for="time in landmark.scheduleList" :key="time.id">
            <span>{{ time.dayName }} :</span> {{ time.openTime | fo }}
            -
            {{ time.closeTime }}
          </li>
        </ul>
      </div>
      <div class="form-group">
        <label for="landmarkPrice">Price: </label>
        <p>Needs to wire price here</p>
      </div>
      <button
        class="btn btn-cancel btn-secondary"
        type="button"
        value="cancel"
        v-on:click="cancelForm"
      >
        Hide Details
      </button>
    </form>
  </div>
</template>

<script>
import Landmark from "./Landmark.vue";
export default {
  name: "landmark_details",
  props: ["landmark"],
  data() {
    return {
      showForm: false,
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
  font-size: 1em;
  font-weight: bold;
  margin-top: 20px;
  outline: none;
  border: none;
  border-radius: 5px;
  transition: 0.2s ease-in;
  cursor: pointer;
}
span {
  font-weight: 700;
}
.schedule-info {
  font-size: 1.3em;
  font-weight: 800;
}
</style>