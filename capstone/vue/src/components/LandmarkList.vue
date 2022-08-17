<template>
  <div id="grid">
    <div id="searchBar">
      <v-col>
        <v-text-field
          v-model="filter.landmarkName"
          label="Enter search here..."
          filled
        ></v-text-field>
        <v-card id="categoryFilterBox" class="mx-auto" max-width="400" tile>
          <v-list shaped>
            <v-subheader>CATEGORIES</v-subheader>
            <v-list-item-group>
              <v-list-item
                v-for="category of landmarkCategories"
                :key="category.id"
                @click="
                  {
                    categoryCheck(category);
                  }
                "
              >
                <v-list-item-content>
                  <v-list-item-title v-text="category"></v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list-item-group>
          </v-list>
        </v-card>
      </v-col>
    </div>
    <create-itinerary id="createItinerary"></create-itinerary>

    <img id="logo" src="\assets\Cincinnati Local Look-1 (2).png" alt="Logo" />
    <div id="landmarkListContainer">
      <div v-for="landmark in filteredList" v-bind:key="landmark.id">
        <landmark :landmark="landmark" />
      </div>
    </div>
  </div>
</template>

<script>
import Landmark from "./Landmark.vue";
import landmarkServices from "../services/LandmarkServices";
import CreateItinerary from "./CreateItinerary.vue";

export default {
  name: "landmark-list",
  data() {
    return {
      filter: {
        landmarkName: "",
        landmarkCategory: "",
      },
    };
  },
  /**
   * Not sure if in production it makes sense to use created
   * lifecycle hook in each component it is used individually.
   */
  created() {
    landmarkServices.getLandmarks().then((response) => {
      this.$store.commit("POPULATE_LANDMARKS", response.data);
    });
  },
  computed: {
    /**
     * filteredList() first checks for the filter by category, if it is used
     * then we enter a nested conditional to account for the value bound to
     * the searchbar (landmarkName). If we don't use the filter by category
     * and only use the searchbar, then we bounce to the second check i.e.
     * the 'else if' statement.
     */
    filteredList() {
      let filteredLandmarks = this.$store.state.landmarks;

      if (this.filter.landmarkCategory != "") {
        filteredLandmarks = this.$store.state.landmarks.filter((Landmark) =>
          Landmark.category
            .toLowerCase()
            .includes(this.filter.landmarkCategory.toLowerCase())
        );
        if (this.filter.landmarkName != "") {
          filteredLandmarks = this.$store.state.landmarks.filter(
            (Landmark) =>
              Landmark.landmarkName
                .toLowerCase()
                .includes(this.filter.landmarkName.toLowerCase()) &&
              Landmark.category
                .toLowerCase()
                .includes(this.filter.landmarkCategory.toLowerCase())
          );
        }
      } else if (this.filter.landmarkName != "") {
        filteredLandmarks = this.$store.state.landmarks.filter((Landmark) =>
          Landmark.landmarkName
            .toLowerCase()
            .includes(this.filter.landmarkName.toLowerCase())
        );
      }
      return filteredLandmarks;
    },
    landmarkCategories() {
      // TODO: remove duplicates
      let landmarkCategories = [];
      for (let landmark of this.$store.state.landmarks) {
        landmarkCategories.push(landmark.category);
      }
      return landmarkCategories;
    },
  },
  methods: {
    /**
     * Made this method to handle category filtering.
     * Now if you click on a category once it filters by it,
     * and if the same category is clicked again the category filter is cleared.
     */
    categoryCheck(category) {
      this.filter.landmarkCategory == category
        ? (this.filter.landmarkCategory = "")
        : (this.filter.landmarkCategory = category);
    },
  },
  components: {
    Landmark,
    CreateItinerary,
  },
};
</script>

<style scoped>
#searchBar {
  padding: 1rem;
  display: flex;
  justify-content: center;
  grid-area: ga-searchBar;
}

#landmarkListContainer {
  grid-area: ga-landmarkList;
}

#logo {
  grid-area: ga-logo;
  max-block-size: 100px;
  border-radius: 50%;
  justify-self: center;
}

#grid {
  display: grid;
  grid-template-columns: 1fr 3fr 1fr;
  grid-template-areas:
    "ga-logo . ."
    "ga-searchBar ga-landmarkList ga-createItinerary"
    "ga-radioSelector ga-landmarkList .";
}

#categorySelector {
  padding-bottom: 1rem;
}

#categoryFilterBox {
  grid-area: ga-radioSelector;
  justify-self: center;
  padding: 1rem;
}

.hidden {
  display: none;
}

#createItinerary {
  grid-area: ga-createItinerary;
  justify-self: center;
}

@media screen and (max-width: 800px) {
  #grid {
    grid-template-columns: 1fr;
    grid-template-areas:
      "ga-logo"
      "ga-createItinerary"
      "ga-searchBar"
      "ga-radioSelector"
      "ga-landmarkList";
  }
  #searchBar {
    padding: 1rem;
    display: flex;
    justify-content: center;
  }

  #categorySelector {
    padding-bottom: 1rem;
  }

  #categoryFilterBox {
    justify-self: center;
    padding: 1rem;
  }

  #createItinerary {
    justify-self: center;
  }
}
</style>