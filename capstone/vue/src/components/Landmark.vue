<template>
<<<<<<< HEAD
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
=======
  <div class="wrapper">
    <v-card class="mx-auto" width="400">
      <v-img
        class="white--text align-end"
        height="200px"
        :src="landmark.imageUrlList[0]"
      >
      </v-img>

      <v-card-title>{{ landmark.landmarkName }}</v-card-title>
      <v-card-subtitle class="pb-0">{{ landmark.category }} </v-card-subtitle>
      <v-card-text class="text--primary">
        <div>{{ landmark.description }}</div>
      </v-card-text>

      <v-card-actions>
        <v-btn color="blue">
          {{ landmark.upRatings }} <i class="fa-regular fa-thumbs-up"></i>
        </v-btn>

        <v-btn color="red">
          {{ landmark.downRatings }} <i class="fa-regular fa-thumbs-down"></i>
        </v-btn>
      </v-card-actions>
    </v-card>
  </div>

  <!-- <div class="container">
    <h2>{{ landmark.landmarkName }}</h2>
    <h4>{{ landmark.description }}</h4>
    <h4>{{ landmark.category }}</h4>
    <h4>
      <span style="color: blue"
        >{{ landmark.upRatings }} <i class="fa-regular fa-thumbs-up"></i
      ></span>
    </h4>
    <h4>
      <span style="color: red">
        {{ landmark.downRatings }} <i class="fa-regular fa-thumbs-down"></i
      ></span>
    </h4>
    <v-carousel>
      <v-carousel-item
        v-for="(imageUrl, i) in landmark.imageUrlList"
        :key="i"
        :src="imageUrl"
        reverse-transition="fade-transition"
        transition="fade-transition"
      ></v-carousel-item>
    </v-carousel>
  </div> -->
</template>

<script>
export default {
  name: "Landmark",
  props: {
    landmark: Object,
  },
};
</script>

<style scoped>
.wrapper {
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-bottom: 20px;
}
/* 
.container {
  padding: 1rem;
  margin: 25px auto 25px auto;
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 2px solid black;
  justify-content: center;
  flex-wrap: wrap;
  max-width: 500px;
} */
</style>
>>>>>>> a441677465ff3de7d7dbd7783162358a5bb15601
