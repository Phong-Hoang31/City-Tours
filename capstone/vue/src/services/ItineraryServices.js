import axios from 'axios';

export default {

    createItinerary(itinerary) {
        return axios.post(`/itineraries`, itinerary)
    },

    getAllItineraries() {
        return axios.get('/itineraries')
    },

    addLandmarkToItinerary(itinerary, landmark) {
        return axios.post(`/itineraries/${itinerary.id}`, landmark)
    }
}