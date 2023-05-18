<template>
  <div id="app">
    <h1 class="text-center">Fitness App</h1>
    <hr />
    <div class="container">
      <add-exercise-form></add-exercise-form>
      <hr />
      <exerciseList></exerciseList>
    </div>
  </div>
</template>

<script>
import addExerciseForm from "./components/add-exercise-form.vue";
import exerciseList from "./components/exercise-list.vue";
export default {
  name: "App",
  components: {
    exerciseList,
    addExerciseForm,
  },
};
</script>

<style></style>
