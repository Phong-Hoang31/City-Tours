<template>
  <div class="body">
    <form id="detailsForm" v-on:submit.prevent="submitForm">
      <div
        class="form-group"
        v-for="(landmark, index) in itinerary.landmarkList"
        :key="landmark.id"
      >
        <h6>{{ index + 1 }}: {{ landmark.landmarkName }}</h6>
        <i class="fa-solid fa-trash-can"></i>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "itinerary-details",
  props: ["itinerary"],
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
}

.form-group {
  display: flex;
  justify-content: space-between;
}

ul {
  list-style: none;
}
</style>