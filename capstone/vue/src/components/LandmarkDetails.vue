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
        <p>{{ landmark.address }}</p>
      </div>

      <div class="form-group">
        <ul for="Schedule">
          Open Hours:
          <li v-for="time in landmark.scheduleList" :key="time.id">
            {{ time.dayName }}
            {{ time.openTime }} - {{ time.closeTime }}
          </li>
        </ul>
      </div>
      <div class="form-group">
        <label for="landmarkPrice">Price: </label>
        <p>{{ landmark.price }}</p>
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
div.form-group {
  margin: 0px 0px 16px;
}
</style>