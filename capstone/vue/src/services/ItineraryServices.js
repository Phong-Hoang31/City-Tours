import axios from 'axios';

export default {

    createItinerary(itinerary) {
        return axios.post(`/itineraries`, {
            name: itinerary.name,
            startingPoint: itinerary.startingPoint,
            date: itinerary.date,
        });
    },

    // getItineraryByUserId(userId) {
    //     return http.get(`/itinerary/${userId}`);
    // },

    getAllItineraries() {
        return axios.get('/itineraries')
    },
}