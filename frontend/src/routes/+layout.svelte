<script>
	import Footer from './../lib/components/layout/Footer.svelte';
	import './styles.css';
	import Header from '$lib/components/layout/Header.svelte';
</script>

<Header />
<main>
	<slot />
</main>

<Footer />

<style>
</style>
