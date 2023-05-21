<script lang="ts">
	import { validateForm, type FormValue } from '$lib/helpers/formValidation';
	import { Label, Input, Heading, Button, Checkbox, ButtonGroup, Helper } from 'flowbite-svelte';

	type FormInputName = 'email' | 'password' | 'name' | 'rememberMe';
	const formValues: Record<FormInputName, FormValue> = {
		email: {
			value: '',
			validation: {
				isEmail: true,
				minLen: 10
			}
		},
		password: {
			value: '',
			validation: {
				minLen: 6
			}
		},
		name: {
			value: '',
			validation: {
				minLen: 6
			}
		},
		rememberMe: {
			value: '',
			isChecked: false
		}
	};

	const handleSubtmit = async (e: SubmitEvent) => {
		const { errors, isValid } = validateForm(formValues);
		Object.entries(errors).forEach(([key, data]) => {
			const typedKey = key as FormInputName;
			if (formValues[typedKey]) {
				formValues[typedKey].error = data;
			}
		});
		if (!isValid) {
			e.preventDefault();
		}
	};

	$: ({ email, password, name, rememberMe } = formValues);
</script>

<section class="bg-gray-50 dark:bg-gray-900">
	<div class="py-8 px-4 mx-auto max-w-screen-xl lg:py-16 grid lg:grid-cols-2 gap-8 lg:gap-16">
		<div>
			<div
				class="w-full lg:max-w-xl p-6 space-y-8 sm:p-8 bg-white rounded-lg shadow-xl dark:bg-gray-800"
			>
				<h2 class="text-2xl font-bold text-gray-900 dark:text-white">Sign in to StrawPoll</h2>
				<form class="mt-8 space-y-6" action="#" method="POST" on:submit={handleSubtmit}>
					<div>
						<Label for="error" class="block mb-2">Your email</Label>
						<Input
							bind:value={email.value}
							on:input={() => {
								email.error = undefined;
							}}
							color={email.error ? 'red' : 'base'}
							id="success"
							name="email"
							placeholder="Success input"
						/>
						{#if email.error}
							<Helper class="mt-2" color="red">
								{email.error}
							</Helper>
						{/if}
					</div>
					<div>
						<Label for="error" class="block mb-2">Your name</Label>
						<Input
							bind:value={name.value}
							on:input={() => {
								name.error = undefined;
							}}
							color={name.error ? 'red' : 'base'}
							id="success"
							name="name"
							placeholder="Success input"
						/>
						{#if name.error}
							<Helper class="mt-2" color="red">
								{name.error}
							</Helper>
						{/if}
					</div>
					<div>
						<Label for="error" class="block mb-2">Your passowrd</Label>
						<Input
							bind:value={password.value}
							on:input={() => {
								password.error = undefined;
							}}
							color={password.error ? 'red' : 'base'}
							id="success"
							name="password"
							type="password"
							placeholder="Success input"
						/>
						{#if password.error}
							<Helper class="mt-2" color="red">
								{password.error}
							</Helper>
						{/if}
					</div>
					<div class="flex items-start">
						<Checkbox checked={rememberMe.isChecked} name="rememberMe">Remember me</Checkbox>
						<a
							href="#"
							class="ml-auto text-sm font-medium text-blue-600 hover:underline dark:text-blue-500"
							>Lost Password?</a
						>
					</div>
					<Button type="submit">Login to your account</Button>
					<div class="text-sm font-medium text-gray-900 dark:text-white">
						Not registered yet? <a
							href="/auth/login"
							class="text-blue-600 hover:underline dark:text-blue-500">Create account</a
						>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
