<template>
  <div>
    <div class="row mb-2 fw-bold font-weight-bold">
      <div class="col-2">#</div>
      <div class="col-4">Exercise</div>
      <div class="col-2">Sets</div>
      <div class="col-2">Rep</div>
    </div>
    <hr />
    <exerciseItem
      v-for="(exercise, i) in exerciseList"
      :key="i"
      :index="i"
      :exercise="exercise"
    ></exerciseItem>
  </div>
</template>

<script>
import { getAllExercise } from '../api';
import { mapGetters } from 'vuex';
import exerciseItem from "./exercise-item.vue";
export default {
  name: "ExerciseList",
  components: { exerciseItem },
  props: {
    msg: String,
  },
  computed: {
    ...mapGetters(['exerciseList'])
  },
  methods: {},
  beforeMount() {
    getAllExercise()
    .then((resp) => {
        console.log(resp);
        this.$store.commit('setList', resp.data);
    })
    .catch((err) => {
        console.log(err);
    });
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
