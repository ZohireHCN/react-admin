export default function FieldRenderer({ field, register }) {
  if (field.readonly) {
    return null;
  }

  return (
    <div style={{ marginBottom: 16 }}>
      <label>
        <div>{field.label}</div>

        {field.type === 'boolean' ? (
          <input
            type="checkbox"
            {...register(field.name)}
          />
        ) : (
          <input
            type={field.type || 'text'}
            {...register(field.name, {
              required: field.required,
            })}
          />
        )}
      </label>
    </div>
  );
}