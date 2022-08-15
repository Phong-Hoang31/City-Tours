<template>
  <div class="body">
    <button
      id="show-form-button"
      href="#"
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
      this.itinerary = {};
      this.showForm = false;
      this.$router.go();
    },
  },
};
</script>

<style lang="scss" scoped>
</style>