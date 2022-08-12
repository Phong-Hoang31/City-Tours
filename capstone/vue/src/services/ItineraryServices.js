import axios from 'axios';

export default {

    createItinerary(itinerary) {
        return axios.post(`/itineraries`, itinerary)
    },

    // getItineraryByUserId(userId) {
    //     return http.get(`/itinerary/${userId}`);
    // },

    getAllItineraries() {
        return axios.get('/itineraries')
    },
}