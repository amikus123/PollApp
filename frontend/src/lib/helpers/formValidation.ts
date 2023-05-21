import { capitalizeFirstLetter } from './stringHelpers';

interface Validation {
	minLen?: number;
	maxLen?: number;
	required?: boolean;
	isEmail?: boolean;
}
export interface FormValue {
	value: string | number;
	isChecked?: boolean;
	validation?: Validation;
	error?: string;
}

const validateEmail = (email: string) => {
	const emailRegex = /^\S+@\S+\.\S+$/;
	return emailRegex.test(email);
};

enum ErrorType {
	EMAIL,
	MAX_LEN,
	MIN_LEN,
	REQUIRED
}

const createErrorMessage = (name: string, errorType: ErrorType, len?: number) => {
	const capitalizedName = capitalizeFirstLetter(name);
	switch (errorType) {
		case ErrorType.EMAIL:
			return `${capitalizedName} is not a valid email`;
		case ErrorType.REQUIRED:
			return `${capitalizedName} is required`;
		case ErrorType.MIN_LEN:
			return `${capitalizedName} mus be at least ${len} characters long`;
		case ErrorType.MAX_LEN:
			return `${capitalizedName} mus be at max ${len} characters long`;
	}
};

export const validateForm = (formData: Record<string, FormValue>) => {
	let isValid = true;
	const errors: Record<string, string> = {};

	Object.entries(formData).forEach(([key, data]) => {
		const { value, validation, isChecked } = data;
		if (validation) {
			const { maxLen, minLen, required, isEmail } = validation;

			if (required) {
				if (
					(typeof value === 'string' && value === '' && isChecked === undefined) ||
					(typeof isChecked === 'boolean' && !isChecked) ||
					(typeof value === 'number' && value === 0)
				) {
					isValid = false;
					errors[key] = createErrorMessage(key, ErrorType.REQUIRED);
					return;
				}
			}

			// len validation
			if (typeof value === 'string') {
				if (minLen && value.length < minLen) {
					isValid = false;
					errors[key] = createErrorMessage(key, ErrorType.MIN_LEN, minLen);
					return;
				}
				if (maxLen && value.length > maxLen) {
					isValid = false;
					errors[key] = createErrorMessage(key, ErrorType.MAX_LEN, maxLen);
					return;
				}
				if (isEmail && !validateEmail(value)) {
					isValid = false;
					errors[key] = createErrorMessage(key, ErrorType.EMAIL);
					return;
				}
			}
		}
	});

	return { errors, isValid };
};
