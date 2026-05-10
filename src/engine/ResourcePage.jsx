import ListRenderer from './ListRenderer';
import FormRenderer from './FormRenderer';

export default function ResourcePage({ resource }) {
  return (
    <div>
      <h1>{resource.label}</h1>

      <section style={{ marginBottom: 32 }}>
        <h2>List</h2>
        <ListRenderer resource={resource} />
      </section>

      <section>
        <h2>Create / Edit</h2>
        <FormRenderer resource={resource} />
      </section>
    </div>
  );
}