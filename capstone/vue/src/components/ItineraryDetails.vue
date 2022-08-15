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
         name: "itinerary-details",
         data() {
    return {
      showForm: false,
      userId: null,
    };
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
</style>