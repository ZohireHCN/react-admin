import { useForm } from 'react-hook-form';
import FieldRenderer from './FieldRenderer';

export default function FormRenderer({ resource }) {
  const { register, handleSubmit } = useForm();

  const onSubmit = data => {
    console.log('Form data:', data);
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      {resource.fields.map(field => (
        <FieldRenderer
          key={field.name}
          field={field}
          register={register}
        />
      ))}

      <button type="submit">Save</button>
    </form>
  );
}