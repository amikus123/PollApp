<script lang="ts">
	import { Label, Input, InputAddon, ButtonGroup, Helper } from 'flowbite-svelte';
</script>

<section class="bg-gray-50 dark:bg-gray-900">
	<div class="py-8 px-4 mx-auto max-w-screen-xl lg:py-16 grid lg:grid-cols-2 gap-8 lg:gap-16">
		<div>
			<div
				class="w-full lg:max-w-xl p-6 space-y-8 sm:p-8 bg-white rounded-lg shadow-xl dark:bg-gray-800"
			>
				<h2 class="text-2xl font-bold text-gray-900 dark:text-white">Sign in to Flowbite</h2>
				<form class="mt-8 space-y-6" action="#">
					<div>
						<Label for="error" color="red" class="block mb-2">Your name</Label>
						<Input id="success" color="red" placeholder="Success input" />
						<Helper class="mt-2" color="red"
							><span class="font-medium">Well done!</span> Some success message.</Helper
						>
					</div>
					<div>
						<Label for="error" color="red" class="block mb-2">Your name</Label>
						<Input id="success" color="red" placeholder="Success input" />
						<Helper class="mt-2" color="red"
							><span class="font-medium">Well done!</span> Some success message.</Helper
						>
					</div>
					<div class="flex items-start">
						<div class="flex items-center h-5">
							<input
								id="remember"
								aria-describedby="remember"
								name="remember"
								type="checkbox"
								class="w-4 h-4 border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-blue-300 dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:bg-gray-700 dark:border-gray-600"
								required
							/>
						</div>
						<div class="ml-3 text-sm">
							<label for="remember" class="font-medium text-gray-500 dark:text-gray-400"
								>Remember this device</label
							>
						</div>
						<a
							href="#"
							class="ml-auto text-sm font-medium text-blue-600 hover:underline dark:text-blue-500"
							>Lost Password?</a
						>
					</div>
					<button
						type="submit"
						class="w-full px-5 py-3 text-base font-medium text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 sm:w-auto dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
						>Login to your account</button
					>
					<div class="text-sm font-medium text-gray-900 dark:text-white">
						Not registered yet? <a class="text-blue-600 hover:underline dark:text-blue-500"
							>Create account</a
						>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
