import axios from 'axios';



export default {

    // createItinerary(startingPoint, date) {
    //     return http.post(`/createItinerary`, {
    //         startingPoint: startingPoint,
    //         date: date
    //     });
    // },
    // getItineraryByUserId(userId) {
    //     return http.get(`/itinerary/${userId}`);
    // },

    getAllItineraries() {
        return axios.get('/itineraries')
    },
}