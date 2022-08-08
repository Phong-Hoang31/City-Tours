<template>
  <div class="landmark" v-bind:key="landmark.id">
    <h4>{{ landmark.landmarkName }}</h4>
    <div class="photos">
      <img />
    </div>
    <h3>{{ landmark.category }}</h3>
    <p>{{ landmark.description }}</p>
  </div>
</template>

<script>
</script>

<style>
div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review.favorited {
  background-color: lightyellow;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}
</style>