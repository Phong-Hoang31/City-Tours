<template>
<div>
  <div v-for="landmark in landmarks"
      v-bind:key="landmark.id"
     >

  </div>
  </div>
</template>

<script>
import landmarkService from "../services/LandmarkServices";

export default {
  name: "landmark-list",
  // methods: {
  //   // TODO: Make this method valid
  // },
  //   //  getLandmark(landmarkId) {
  //   //    this.$router.push(`/landmarks/${landmarkId}`)
  //   //  }, 
    
  data() {
    return {
      landmarks: [],
    };
  },
  created() {
    landmarkService.getLandmarks().then((response) => {
      this.landmarks = response.data;
    });
  },
};

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